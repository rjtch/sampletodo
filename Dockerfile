FROM ubuntu:20.04 

RUN apt update \
    && apt upgrade -y \
    && apt install -y libpcre3 libpcre3-dev zlib1g zlib1g-dev openssl libssl-dev wget git gcc make libbrotli-dev

RUN chmod u+x notification-build.sh

RUN chmod u+x todo-build.sh

RUN chmod u+x user-build.sh