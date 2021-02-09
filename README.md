# SPRING_MVC κΈ°μ΄

 **[?λ‘μ ?Έ κ΅¬μ‘°](#?λ‘μ ?Έ-κ΅¬μ‘°)** /
 **[Maven](#Maven)** /
 **[Lombok](#Lombok)** /
 **[log4j](#Log4j)** /
 **[junit](#Junit)** /
 **[?μ‘΄μ± μ£Όμ](#?μ‘΄μ±-μ£Όμ)** /
 **[SpringMVC](#SpringMVC)** /
 **[μ»¨νΈλ‘€λ¬](#μ»¨νΈλ‘€λ¬)** /
 **[DB?°κ²?](#DB?°κ²?)** /
 **[κ³μΈ΅](#κ³μΈ΅)** /
 **[REST](#REST)** /
 **[?λ‘μ ?Έ κ΅¬μ‘°](#?λ‘μ ?Έ-κ΅¬μ‘°)** /
 **[Maven](#Maven)** /
 **[Lombok](#Lombok)** /
 **[log4j](#Log4j)** /
 **[junit](#Junit)** /
 **[?μ‘΄μ± μ£Όμ](#?μ‘΄μ±-μ£Όμ)** /
 **[SpringMVC](#SpringMVC)** /
 **[μ»¨νΈλ‘€λ¬](#μ»¨νΈλ‘€λ¬)** <br>
 
 **[DB?°κ²?](#DB?°κ²?)** /
 **[κ³μΈ΅](#κ³μΈ΅)** /
 **[REST](#REST)** /
 **[Ajax](#Ajax)** /


## ?λ‘μ ?Έ κ΅¬μ‘°
![projectStandard](./img/?λ‘μ ?Έκ΅¬μ‘°?¨?€μ§?.png)
- src/main/java : ?λ°? μ½λλ₯? ??±??κ³? <br>
- src/main/resources : ?λ°? μ½λλ₯? ?€??  ? ??? ??Ό?€? λ³΄κ??? κ³?

- src/test/java : ??±? ?λ°? μ½λ? ??€?Έλ₯? ??± ??κ³?
- src/test/resources : ??€?Έ μ½λλ₯? ?€??  ? ??? ??Ό?€? λ³΄κ??? κ³?

- src : ?Ή μ½λλ₯? ??±?? κ³? 
  - root-context.xml : ?€?λ§? ?λ‘μ ?Έ ? μ²? ?€?  ??Ό
  - servlet-context.xml : DispatcherServlet? ?λ°? μ½λ??΄ ?€λ£? ? ?? ?€?  ??Ό
  
- pom.xml : Maven ?€?  ??Ό
- target : ?€? λ‘? λ§λ€?΄μ§? ?λ‘μ ?Έλ₯? λ―Έλ¦¬ λ³? ? ??
## Maven

## Lombok
  
## Log4j
 
## Junit
  
## ?μ‘΄μ± μ£Όμ

## SpringMVC
 
## μ»¨νΈλ‘€λ¬

## DB?°κ²?

## κ³μΈ΅

## REST
 ### REST??
  - Mapping?΄λ¦μΌλ‘? URI?λ―Έλ?? ??
	- ?΄ ??? ?°λ₯? ??€?? RESTful?΄?Όκ³? ??€.
	- RESTful? ?°λ₯΄λ©΄ ?Ή?λ²κ? ?Ή λΈλΌ?°?? λΏλ§?΄ ???Ό λͺ¨λ°?Ό ?±κ³Όλ ?°κ²°λ  ? ??€
  - ??? URIλ§? κ°?μ§?κ³ λ CRUDλ₯? λͺ¨λ κ΅¬ν?  ? ??€.
  ```java
  @PostMapping // CREATE
  @GetMapping // READ
  @PutMapping // UPDATE(? μ²?)
  @PatchMapping // UPDATE(?ΌλΆ?)
  @DeleteMapping // DELETE
  ```
 ### μΆκ??  Maven
  - jackson-databind
  - jackson-dataformat-xml
  - gson
  
 ### ?΄?Έ??΄?
 ```java
 @RestController
 public class RestSampleController {
 ```
- ?Όλ°? μ»¨νΈλ‘€λ¬?? ?€λ₯΄κ² λ·°λ‘ ?¬???μ§? ?κ³? ?°?΄?°λ₯? λ°λ‘ λ°ν?? μ»¨νΈλ‘€λ¬
- ?Όλ°? μ»¨νΈλ‘€λ¬?? @ResposneBody ?΄?Έ??΄?? ?¬?©?΄ ? ?©?  ?? ??€.

```java
@PostMapping(value = "/employee/create",
            consumes = "application/json",
            produces = "text/plain; charset=UTF-8"
				)
public ResponseEntity<Employee> createEmployee(@RequestBody Employee new_emp) {
```
- Jackson-databind?? ?¨κ»? ?¬?©?λ©? JSON ?? XMLλ‘? ? ?¬? ?°?΄?°λ₯? κ°νΈ?κ²? VOλ‘? λ³???΄μ€??€.

## Ajax
 ### Asynchronous JavaScript and XML (or JSON) / ?Ή?λ²? λΉλκΈ? ?΅? 
 - ??΄μ§?λ₯? λ³????€μ§? ??Όλ©΄μ ?Ή ?λ²λ‘ ?μ²?? λ³΄λΈ?€.
 - λ³΄λΈ ?μ²??΄ ?μ°©νλ©? readyStateκ°μ΄ λ³???€.
 - readyStateκ°? 0-UNSET / 1-OPEND / 2-SEND / 3-LOADING / 4-DONE 
 
 ### ?? 
 ```javascript
 // ?μ²? κ°μ²΄
 xhr = new XMLHttpRequest();
 
 // readtState λ³?? κ°μ??΄λ²€νΈ
 xhr.onreadystatechange = function() {}
 
 // λ§€ν λ°©μ, μ£Όμ, λΉλκΈ? ?¬λΆ?
 xhr.open('GET/POST/...', uri, true) // 1
 
 // 
 xhr.send // 2
 ```
 
