# Showcase REST Client Project

This project demonstrates the use of different HTTP clients in a Spring Boot application to interact with the JSONPlaceholder API. The clients used are:
- Spring RestTemplate
- Spring WebClient
- Spring RestClient (with HttpServiceProxyFactory)

## Project Structure

- `restclient/raw`: Uses RestClient directly.
- `restclient/interfac`: Uses RestClient with HttpServiceProxyFactory.
- `webclient/raw`: Uses WebClient directly.
- `webclient/interfac`: Uses WebClient with HttpServiceProxyFactory.
- `resttemplate/raw`: Uses RestTemplate directly.

## HTTP Clients Overview

### RestTemplate

**Advantages:**
- Simple and easy to use.
- Synchronous by default, making it straightforward for blocking operations.
- Feature complete and stable.

**Disadvantages:**
- Limited support for reactive programming.
- Not recommended for new applications in favor of WebClient.
- In maintenance mode since Spring 5.2, with a possibility of removal in future versions.

### WebClient

**Advantages:**
- Supports both synchronous and asynchronous operations.
- Better suited for reactive programming.
- More flexible and powerful than RestTemplate.

**Disadvantages:**
- More complex to configure and use.
- Requires understanding of reactive programming concepts for non-blocking operations.

### RestClient (with HttpServiceProxyFactory)

**Advantages:**
- Simplifies HTTP client creation by using interfaces.
- Reduces boilerplate code.
- Can be used with both RestTemplate and WebClient under the hood.

**Disadvantages:**
- Newer and less mature compared to RestTemplate and WebClient.
- Requires additional configuration.

**Spring Docs:**
https://docs.spring.io/spring-framework/reference/web/webmvc-client.html

## Conclusion

Each HTTP client has its own strengths and weaknesses. RestTemplate is simple, synchronous, and feature complete but has limited support for reactive programming and is in maintenance mode with a possibility of future removal. WebClient is powerful and supports reactive programming but is more complex. RestClient with HttpServiceProxyFactory simplifies client creation and reduces boilerplate but is newer and less mature. Choose the one that best fits your application's needs.