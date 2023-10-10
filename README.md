# Backend eCommerce Project using Spring Boot

## Description
The Backend eCommerce Project is a robust backend system for an online shopping platform. It handles essential functionalities like user authentication, product management, order processing, and data storage in a MySQL database. This project serves as the backbone of an eCommerce website.

## Table of Contents

- [Installation](#installation)
- [Technologies Used](#technologies-used)
- [Features](#features)
- [Usage](#usage)
- [Contributing](#contributing)

## Installation

To get started with our E-commerce Backend App, follow these steps:

1. **Clone the repository:**

   ```bash
   git clone https://github.com/Shittu24/ecommerce-backend.git
   cd ecommerce-backend

2. **Set up MySQL Database:**
   - Ensure you have MySQL installed on your system.
   - Create a MySQL database for the application.
   - Update the database configuration in `src/main/resources/application.properties` with your database settings:
  
     ```bash
      spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
      spring.datasource.username=your_username
      spring.datasource.password=your_password

3. **Build and run the application:**

   ```bash
   ./mvnw clean install
   ./mvnw spring-boot:run

The application should now be up and running.



## Technologies Used
- **Java**: The primary programming language.
- **Spring Boot**: A powerful framework for building Java applications.
- **MySQL**: The relational database used for data storage.
- **Lombok**: Generates boilerplate code, such as getters, setters, constructors, and more through annotations.
- **Spring Data JPA**: Simplifies database operations.
- **Spring MVC**: Handles HTTP requests and responses.
- **Maven**: Dependency management.

## Features

Our E-commerce Backend App offers a comprehensive set of features to support a seamless online shopping experience:

- **Order Management**: Create, retrieve, and manage customer orders efficiently.
- **Product Inventory**: Keep track of available products and their details.
- **Customer Management**: Manage customer information and profiles.
- **Order Tracking**: Assign and track unique order tracking numbers.
- **Secure Authentication**: Implement secure user authentication and access control.
- **API Integration**: Interact with external APIs to retrieve product information.
- **Payment Gateway Integration**: Seamlessly integrate payment gateways for order processing.
- **Location Management**: Store and manage location data for shipping and fulfillment.
- **Database Storage**: Utilize a MySQL database to store and manage order data.
- **Testing and Quality Assurance**: Rigorous testing and quality checks to ensure reliability.

We are continually enhancing our app with new features and improvements to provide a comprehensive e-commerce solution.



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

    - Response Example:
      ```json
      {
          "orderTrackingNumber": "997e311f-be72-4c45-98ac-86e5541f4c5e"
      }
                 

## Contributing
Contributions are welcome! If you'd like to contribute to this project, please follow these guidelines:
- Fork the repository.
- Create a new branch for your feature or bug fix.
- Make your changes and submit a pull request.
  

## Contact
For questions or support, please contact [Ibrahim](mailto:ibrahimshittu007@gmail.com).
