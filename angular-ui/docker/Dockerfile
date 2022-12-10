FROM nginx:alpine
COPY ./dist /usr/share/nginx/html
RUN rm /etc/nginx/conf.d/default.conf
COPY ./conf/default.conf /etc/nginx/conf.d/default.conf
COPY ./src/info.json /usr/share/nginx/html/version.json