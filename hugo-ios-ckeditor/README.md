Source code of the product: 

https://github.com/0xMichaelRan/iOS-CKEditor

The static site is published not using Github Pages, but rather on the racknerd VPS at:

https://ios-ckedit.345321.xyz/

Config of Nginx as follows:

```
server {
    listen 80;
    server_name ios-ckedit.345321.xyz;

    root /home/rslsync/_resilio/Blogs/splash-demos/hugo-ios-ckeditor/public/;
    index index.html;

    location / {
        try_files $uri $uri/ =404;
    }
}
```
