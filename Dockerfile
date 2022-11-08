FROM ubuntu:20.04 

RUN apt update \
    && apt upgrade -y \
    && apt install -y libpcre3 libpcre3-dev zlib1g zlib1g-dev openssl libssl-dev wget git gcc make libbrotli-dev
    
WORKDIR /app
COPY notification-build.sh /app
RUN chmod u+x /app/notification-build.sh

COPY todo-build.sh /app
RUN chmod u+x /app/todo-build.sh

COPY user-build.sh /app
RUN chmod u+x /app/user-build.sh