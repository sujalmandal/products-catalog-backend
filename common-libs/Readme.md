This library does the followings
- **Injects a restTemplate created using restTemplateBuilder** : this should be used to make external API calls to carry forward spring sleuth trace and span headers
- **Injects a @ControllerAdvice to handle MethodArgumentNotValidException** : to handle method level _javax.validation_ errors using @Valid annotation. 
- **Imports javax.validation packages**
- **Imports solace binder for spring cloud stream**
- **Defines common Request/Response POJOs and DTOs to be used throughout the application**