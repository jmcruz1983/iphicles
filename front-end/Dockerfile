# base image
FROM node:10.9.0 AS build-env

# install chrome for protractor tests
RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add -
RUN sh -c 'echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google.list'
RUN apt-get update && apt-get install -yq google-chrome-stable

# set working directory
WORKDIR /front-end

# add `/front-end/node_modules/.bin` to $PATH
ENV PATH /front-end/node_modules/.bin:$PATH

# install and cache app dependencies
COPY package.json /front-end/package.json
RUN npm install
RUN npm install -g @angular/cli

# add front-end source
COPY . /front-end

# build source
RUN ng build --prod

# start app
CMD ng serve --host 0.0.0.0

# 2nd stage
# build front-end image for release
FROM nginx:1.13.0

# set working directory
WORKDIR /usr/share/nginx/html

# copy generated sources
COPY --from=build-env /front-end/dist/front-end ./

EXPOSE 80
