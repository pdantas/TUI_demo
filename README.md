# TUI_demo

This application is based on spring boot and exposes a simple API that allows for parsing a quotes database, hosted on MongoDB Atlas.

Build the pom.xml and execute class QuotesDemoApplication.

Connection details are defined in the application.properties file.

The application exposes an API through the context /quotes.
There are 3 possible uses:
 * GET /quotes returns all the quotes in the database;
 * GET /quotes?author="..." filters for a specific author; and
 * GET /quotes/{id} looks for a quote that has the provided id.

See class QuoteController for more details on the API.

author: Pedro Ivo Dantas
