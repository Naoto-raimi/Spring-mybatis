FROM mysql:8.0.17

# rootユーザーのパスワード=root
# springデータベースを作成(ユーザー名user、パスワードpassword)
ENV MYSQL_ROOT_PASSWORD=root\
    MYSQL_DATABASE=spring\
    MYSQL_USER=user\
    MYSQL_PASSWORD=password

COPY mysql-config.cnf /etc/mysql/conf.d

EXPOSE 3306
