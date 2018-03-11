#!/bin/sh
#curl http://localhost:4444/oauth2/auth?client_id=springclient&redirect_uri=http://localhost:8080/login&response_type=code&state=krXTYp

CLIENT=samplecient
CLIENT_SECRET=sampleclientsecret

USER=dan%40acme.com
USER_PASSWORD=secret

TOKEN_ENDPOINT=http://localhost:4444/oauth2/token

set -x

login() {
	curl -v -XPOST "$TOKEN_ENDPOINT" \
		-H 'Content-Type: application/x-www-form-urlencoded;charset=UTF-8' \
		-u "$CLIENT:$CLIENT_SECRET" \
		-d "grant_type=password&grant_type=client_credentials&username=$USER&password=$USER_PASSWORD&client_id=$CLIENT&client_secret=$CLIENT_SECRET" #--trace-ascii /dev/stdout
}

getToken() {
	curl -XPOST "$TOKEN_ENDPOINT" -u "$CLIENT:$CLIENT_SECRET" -d 'grant_type=client_credentials'
}

login
#getToken
