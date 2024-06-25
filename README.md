# TODOS

Mini project for a simple TODO app

## Installation / Local Dev Setup

### Backend

The backend can be run via the IDE starting the spring boot app or using
the gradle task `bootRun`

### Database

For running the backend we need a PostgreSQL database, for which you can run
a standard PostgreSQL docker image in a local container.
Use the SQL script in the projects 'database' folder to generate the required table.
We will introduce 'Flyway' or 'Liquibase' in the future

Please check or adapt `application.properties` for the database user and password.

### Frontend

A very basic Angular FE implementation (todo-webapp). The frontend 'api-client'-folder contains
the generated code for backend-api consumption.

You can run the FE by `ng serve`. The FE has a proxy configured in `proxy.conf.json`
in order to avoid CORS issues in local development.

### Postman

In the 'postman'-folder you will find a collection, so you can
test the backend API.

### API

In the API folder you will find the `api.yaml` file that defines
the backend API and is used as input for the openapi-generator.

The backend controller stubs as well as the FE api client are created
from this file.

## Usage

Very simple use cases:

- ToDos can be created via the 'New'-Button and filling the required information
- ToDos can be set to 'Done' by the 'Finish'-Button
- ToDos can be filtered by category when clicking on one of the category-links

## Roadmap

- Improve FE design
- ...

## License

[MIT](https://choosealicense.com/licenses/mit/)
