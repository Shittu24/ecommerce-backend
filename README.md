# Backend eCommerce Project using Spring Boot

## Description
The Backend eCommerce Project is a robust backend system for an online shopping platform. It handles essential functionalities like user authentication, product management, order processing, and data storage in a MySQL database. This project serves as the backbone of an eCommerce website.

## Table of Contents

- [Installation](#installation)
- [Technologies Used](#technologies-used)
- [Usage](#usage)
  - [Endpoints](#endpoints)
- [Features](#features)
- [Contributing](#contributing)

## Technologies Used
- **Java**: The primary programming language.
- **Spring Boot**: A powerful framework for building Java applications.
- **MySQL**: The relational database used for data storage.
- **Lombok**: Generates boilerplate code, such as getters, setters, constructors, and more through annotations.
- **Spring Data JPA**: Simplifies database operations.
- **Spring MVC**: Handles HTTP requests and responses.
- **Maven**: Dependency management.

## Features

### Product Management
- Read Only operation for products.
- Product categorization by assigning products to categories.
- Search and filtering products by category and name.
- Product details including name, description, and price.

### Product Categories
- Read only  operation for product categories.
- Categorize products for easy navigation and search.
- Assign multiple categories to a single product.

### Location Management
- Management of states and selected countries for shipping and billing information.
- Support for international shipping.


## Usage
1. Access the API endpoints to interact with the backend.
   - Product Management: `/api/products`
   - Product Categories: `/api/product-category`
   - Selected Countries: `/api/countries`
   - States Management: `/api/states`
2. Create an Order:
      - HTTP Method: POST
      - Endpoint: `/api/checkout/purchase`
      - Request Body Example:
        ```json
        {
            "customer":{
               "firstName":"afasa",
               "lastName":"afasa",
               "email":"afasa@test.com"
            },
            "shippingAddress":{
               "street":"afasa",
               "city":"afasa",
               "state":"Alberta",
               "country":"Canada",
               "zipCode":"afasa"
            },
            "billingAddress":{
               "street":"fsfsf",
               "city":"sfdsf",
               "state":"Acre",
               "country":"Brazil",
               "zipCode":"19111"
            },
            "order":{
               "totalPrice":36.98,
               "totalQuantity":2
            },
            "orderItems":[
               {
                  "imageUrl":"assets/images/products/coffeemugs/coffeemug-luv2code-1000.png",
                  "quantity":1,
                  "unitPrice":18.99,
                  "productId":26
               },
               {
                  "imageUrl":"assets/images/products/mousepads/mousepad-luv2code-1000.png",
                  "quantity":1,
                  "unitPrice":17.99,
                  "productId":51
               }
            ]
         }
                 

## Contributing
Contributions are welcome! If you'd like to contribute to this project, please follow these guidelines:
- Fork the repository.
- Create a new branch for your feature or bug fix.
- Make your changes and submit a pull request.
  

## Contact
For questions or support, please contact [Ibrahim](mailto:ibrahimshittu007@gmail.com).
