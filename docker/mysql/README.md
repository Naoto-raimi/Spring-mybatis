
Dockerの使い方
=============

# Dockerのインストール
https://www.docker.com/products/docker-desktop

# イメージの作成

```bash
$ cd sources/docker/mysql
$ ./docker-build.sh
```

# コンテナの作成

```bash
$ ./docker-create.sh
```

# コンテナの起動

```bash
$ ./docker-start.sh
```

# コンテナの停止

```bash
$ ./docker-stop.sh
```

# コンテナ内でのbashコマンド実行

```bash
$ ./docker-bash.sh
```
