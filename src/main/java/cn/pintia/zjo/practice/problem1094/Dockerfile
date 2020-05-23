FROM centos:8

RUN curl -o /etc/yum.repos.d/CentOS-Base.repo https://mirrors.aliyun.com/repo/Centos-8.repo && \
    yum makecache && \
    yum install -y gcc gcc-c++

CMD ["/bin/bash"]

