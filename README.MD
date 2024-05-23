Won't work on alipne linux because:

> "You problem is you are using an alpine image, and docker assumes glibc. alpine uses musl not glibc. Hence why /lib64/ld-linux-x86-64.so.2 doesn't exist."
https://www.reddit.com/r/docker/comments/wqxqff/m1_docker_doesnt_find_shared_x64_shared_objects/

More detailed answer:
https://stackoverflow.com/a/66974607/1141880