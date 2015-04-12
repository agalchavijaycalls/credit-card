# Credit Card Example App

## Backend

  - JEE
  - CreditCardStorage
    - for now you have one implementation CreditCardMemoryStorage but nothing prevents you to add
    CreditCardFileStorage or CreditCardDBStorage

## Frontend

  - [AngularJS] v1.3.15
  - AngularJS (Route) v1.3.15
  - [Bootstrap] v3.3.4

## Developed on
  
  - Wildfly-8.1.0.Final
  - IntelliJ IDEA 14.1.1
  - Ubuntu 14.04 LTS
  
## Important note about CORSFilter

  - [Wiki CORS]
  - you should remove that Filter form your app or change configuration
  
## What you can find on fronted app
  
  - How to init angular app
      - app.js
      - index.html (ng-app="app")

  - How to configure angular Route
    - app.js

  - How to wrote your custom directive
    - card-form.directive.js
    - card-search.directive.js
    - status-translate.directive.js
  
  - How to use 3rd-Party Libraries
    - Angular-payments 11-09-2014 https://github.com/laurihy/angular-payments
    
## What you can find on backend app

  - How to configure simple JEE app
  
    - MyApplication.java
    - pom.xml
    - beans.xml
    
  - How to configure CORSFilter 
    - [Wiki CORS]
    - you can use this filter if you want to deploy your app on different server

    
  - How to use hibernate-validator
  
    - pom.xml
    - ValidatorService.java
    - CardDtoValidationTest.java
    - CardDto.java
    
  - How to use custom hibernate-validator annotation
  
    - pom.xml
    - ValidatorService.java
    - CardDtoValidationTest.java
    - CardDto.java
    - CreditCardExpiry.java & CreditCardExpiryValidator.java
    
  - How to prepare unit test base on [Mockito]
  
    - CardDtoValidationTest.java
  
  - How to work with REST
    
    - CreditCardController.java
    - TIP: instead of public Response addNewCard(CardDto dto) you can also use public Response addNewCard(Map<String, String> map)
    
## More resource on my blog:
  
  - [Btbw AngularJS]
  - [Btbw Simple way to start with JAX-RS]
  - [Btbw JSR 303: Bean Validation]

[AngularJS]:http://angularjs.org
[Bootstrap]:http://getbootstrap.com/
[Mockito]:http://mockito.org/
[Btbw AngularJS]:http://www.blog.btbw.pl/category/java-script/angularjs/
[Btbw Simple way to start with JAX-RS]:http://www.blog.btbw.pl/java/simple-way-to-start-with-jax-rs/
[Btbw JSR 303: Bean Validation]:http://www.blog.btbw.pl/java/jsr-303-bean-validation/
[Wiki CORS]:http://en.wikipedia.org/wiki/Cross-origin_resource_sharing
