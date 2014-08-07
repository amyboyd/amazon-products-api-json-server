Amazon Products API JSON Server
===============================

A simple JSON server that returns products from Amazon's websites as JSON - searchable, taggable with affiliate tags.

Install
=======

Clone the repository and `cd` into it.

    cp conf/application.conf.dist conf/application.conf
	wget http://downloads.typesafe.com/play/1.2.5.3/play-1.2.5.3.zip
	unzip play-1.2.5.3.zip
	rm play-1.2.5.3.zip
    chmod +x run-dev-server

Now edit the `aws` section in `conf/application.conf` to put in your access key, secret key, tracking code, and desired response groups and search index.

Usage
=====

Start the server with: `./run-dev-server`

By default, this will run the server at `localhost:12001` (you can change the port in `conf/application.conf`).

**URLs you can use:**

`GET http://localhost:12001/items?country=gb&query=hat` (search for hats on Amazon.co.uk)

`GET http://localhost:12001/items?country=us&query=blue%20boots` (search for blue boots on Amazon.com)

`GET http://localhost:12001/countries` (gets a list of countries you can use for the `country` parameters in `/items`)
