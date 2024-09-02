# Digital Wallet Application

## Project Description
A simple digital wallet application that allows users to create accounts, deposit, withdraw, transfer funds, and view their transaction history.

## Setup Instructions

### Prerequisites
- Java 22
- PostgreSQL

### Setup

1. Clone the repository:

2. Configure `application.properties` with your PostgreSQL credentials.

3. Run the application:

4. Access the application at `http://localhost:8080`.

## API Endpoints

### User Registration
- **POST** `/register`

### User Login
- **POST** `/login`

### View Account Details
- **GET** `/account/{userId}`

### Deposit Funds
- **POST** `/account/{userId}/deposit`

### Withdraw Funds
- **POST** `/account/{userId}/withdraw`

## Testing Instructions
- Run the tests using Maven:
