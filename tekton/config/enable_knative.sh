#!/bin/bash 

set -eu
set -o errexit

CURRENT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

knative_version="knative-v1.7.0"
knative_serving_version="knative-v1.7.0"

#############################################################
#
#    Setup Ingress
#
#############################################################

kubectl apply -f https://projectcontour.io/quickstart/contour.yaml

kubectl rollout status ds envoy -n projectcontour

######################################
## Knative Serving
######################################

kubectl apply \
  --filename "https://github.com/knative/serving/releases/download/$knative_serving_version/serving-crds.yaml "

kubectl apply \
  --filename \
  "https://github.com/knative/serving/releases/download/$knative_serving_version/serving-core.yaml"

kubectl rollout status deploy controller -n knative-serving 
kubectl rollout status deploy activator -n knative-serving 

kubectl apply \
  --filename \
    "https://github.com/knative/net-kourier/releases/download/$knative_serving_version/kourier.yaml"
  
kubectl rollout status deploy 3scale-kourier-control -n knative-serving 
kubectl rollout status deploy 3scale-kourier-gateway -n kourier-system

kubectl patch configmap/config-network \
  -n knative-serving \
  --type merge \
  -p '{"data":{"ingress.class":"kourier.ingress.networking.knative.dev"}}'

cat <<EOF | kubectl apply -n kourier-system -f -
apiVersion: networking.k8s.io/v1
kind: Ingress
metadata:
  name: kourier-ingress
  namespace: kourier-system
spec:
  rules:
  - http:
      paths:
      - path: /
        pathType: ImplementationSpecific
        backend:
          service:
            name: kourier
            port:
              number: 80
EOF

# skip registriesSkippingTagResolving for few local and development registry prefixes
kubectl patch configmap/config-deployment \
    -n knative-serving \
    --type merge \
    -p '{"data":{"registriesSkippingTagResolving": "ko.local,dev.local,example.com,example.org,test.com,test.org,localhost:5000,registry.local:5000"}}'

# set nip.io resolution 
minikube_nip_domain="\"data\":{\"$(minikube ip).nip.io\": \"\"}"
kubectl patch configmap/config-domain \
    -n knative-serving \
    --type merge \
    -p "{$minikube_nip_domain}"

touch "$CURRENT_DIR/knative.installed"