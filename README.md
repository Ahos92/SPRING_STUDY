# SPRING_MVC ê¸°ì´ˆ

 **[?”„ë¡œì ?Š¸ êµ¬ì¡°](#?”„ë¡œì ?Š¸-êµ¬ì¡°)** /
 **[Maven](#Maven)** /
 **[Lombok](#Lombok)** /
 **[log4j](#Log4j)** /
 **[junit](#Junit)** /
 **[?˜ì¡´ì„± ì£¼ì…](#?˜ì¡´ì„±-ì£¼ì…)** /
 **[SpringMVC](#SpringMVC)** /
 **[ì»¨íŠ¸ë¡¤ëŸ¬](#ì»¨íŠ¸ë¡¤ëŸ¬)** /
 **[DB?—°ê²?](#DB?—°ê²?)** /
 **[ê³„ì¸µ](#ê³„ì¸µ)** /
 **[REST](#REST)** /
 **[?”„ë¡œì ?Š¸ êµ¬ì¡°](#?”„ë¡œì ?Š¸-êµ¬ì¡°)** /
 **[Maven](#Maven)** /
 **[Lombok](#Lombok)** /
 **[log4j](#Log4j)** /
 **[junit](#Junit)** /
 **[?˜ì¡´ì„± ì£¼ì…](#?˜ì¡´ì„±-ì£¼ì…)** /
 **[SpringMVC](#SpringMVC)** /
 **[ì»¨íŠ¸ë¡¤ëŸ¬](#ì»¨íŠ¸ë¡¤ëŸ¬)** <br>
 
 **[DB?—°ê²?](#DB?—°ê²?)** /
 **[ê³„ì¸µ](#ê³„ì¸µ)** /
 **[REST](#REST)** /
 **[Ajax](#Ajax)** /


## ?”„ë¡œì ?Š¸ êµ¬ì¡°
![projectStandard](./img/?”„ë¡œì ?Š¸êµ¬ì¡°?Œ¨?‚¤ì§?.png)
- src/main/java : ?ë°? ì½”ë“œë¥? ?‘?„±?•˜?Š”ê³? <br>
- src/main/resources : ?ë°? ì½”ë“œë¥? ?‹¤?–‰?•  ?•Œ ?•„?š”?•œ ?ŒŒ?¼?“¤?„ ë³´ê??•˜?Š” ê³?

- src/test/java : ?‘?„±?•œ ?ë°? ì½”ë“œ?˜ ?…Œ?Š¤?Š¸ë¥? ?‘?„± ?•˜?Š”ê³?
- src/test/resources : ?…Œ?Š¤?Š¸ ì½”ë“œë¥? ?‹¤?–‰?•  ?•Œ ?•„?š”?•œ ?ŒŒ?¼?“¤?„ ë³´ê??•˜?Š” ê³?

- src : ?›¹ ì½”ë“œë¥? ?‘?„±?•˜?Š” ê³? 
  - root-context.xml : ?Š¤?”„ë§? ?”„ë¡œì ?Š¸ ? „ì²? ?„¤? • ?ŒŒ?¼
  - servlet-context.xml : DispatcherServlet?„ ?ë°? ì½”ë“œ?—†?´ ?‹¤ë£? ?ˆ˜ ?ˆ?Š” ?„¤? • ?ŒŒ?¼
  
- pom.xml : Maven ?„¤? • ?ŒŒ?¼
- target : ?‹¤? œë¡? ë§Œë“¤?–´ì§? ?”„ë¡œì ?Š¸ë¥? ë¯¸ë¦¬ ë³? ?ˆ˜ ?ˆ?Œ
## Maven

## Lombok
  
## Log4j
 
## Junit
  
## ?˜ì¡´ì„± ì£¼ì…

## SpringMVC
 
## ì»¨íŠ¸ë¡¤ëŸ¬

## DB?—°ê²?

## ê³„ì¸µ

## REST
 ### REST??
  - Mapping?´ë¦„ìœ¼ë¡? URI?˜ë¯¸ë?? ?‘œ?˜„
	- ?´ ?˜•?‹?„ ?”°ë¥? ?‹œ?Š¤?…œ?„ RESTful?´?¼ê³? ?•œ?‹¤.
	- RESTful?„ ?”°ë¥´ë©´ ?›¹?„œë²„ê? ?›¹ ë¸Œë¼?š°?? ë¿ë§Œ?´ ?•„?‹ˆ?¼ ëª¨ë°”?¼ ?•±ê³¼ë„ ?—°ê²°ë  ?ˆ˜ ?ˆ?‹¤
  - ?•˜?‚˜?˜ URIë§? ê°?ì§?ê³ ë„ CRUDë¥? ëª¨ë‘ êµ¬í˜„?•  ?ˆ˜ ?ˆ?‹¤.
  ```java
  @PostMapping // CREATE
  @GetMapping // READ
  @PutMapping // UPDATE(? „ì²?)
  @PatchMapping // UPDATE(?¼ë¶?)
  @DeleteMapping // DELETE
  ```
 ### ì¶”ê??•  Maven
  - jackson-databind
  - jackson-dataformat-xml
  - gson
  
 ### ?–´?…¸?…Œ?´?…˜
 ```java
 @RestController
 public class RestSampleController {
 ```
- ?¼ë°? ì»¨íŠ¸ë¡¤ëŸ¬?? ?‹¤ë¥´ê²Œ ë·°ë¡œ ?¬?›Œ?“œ?•˜ì§? ?•Šê³? ?°?´?„°ë¥? ë°”ë¡œ ë°˜í™˜?•˜?Š” ì»¨íŠ¸ë¡¤ëŸ¬
- ?¼ë°? ì»¨íŠ¸ë¡¤ëŸ¬?—?„œ @ResposneBody ?–´?…¸?…Œ?´?…˜?„ ?‚¬?š©?•´ ? ?š©?•  ?ˆ˜?„ ?ˆ?‹¤.

```java
@PostMapping(value = "/employee/create",
            consumes = "application/json",
            produces = "text/plain; charset=UTF-8"
				)
public ResponseEntity<Employee> createEmployee(@RequestBody Employee new_emp) {
```
- Jackson-databind?? ?•¨ê»? ?‚¬?š©?•˜ë©? JSON ?˜?Š” XMLë¡? ? „?‹¬?œ ?°?´?„°ë¥? ê°„í¸?•˜ê²? VOë¡? ë³??™˜?•´ì¤??‹¤.

## Ajax
 ### Asynchronous JavaScript and XML (or JSON) / ?›¹?„œë²? ë¹„ë™ê¸? ?†µ?‹ 
 - ?˜?´ì§?ë¥? ë³??™”?‹œ?‚¤ì§? ?•Š?œ¼ë©´ì„œ ?›¹ ?„œë²„ë¡œ ?š”ì²??„ ë³´ë‚¸?‹¤.
 - ë³´ë‚¸ ?š”ì²??´ ?„ì°©í•˜ë©? readyStateê°’ì´ ë³??•œ?‹¤.
 - readyStateê°? 0-UNSET / 1-OPEND / 2-SEND / 3-LOADING / 4-DONE 
 
 ### ?˜ˆ? œ
 ```javascript
 // ?š”ì²? ê°ì²´
 xhr = new XMLHttpRequest();
 
 // readtState ë³??™” ê°ì??´ë²¤íŠ¸
 xhr.onreadystatechange = function() {}
 
 // ë§¤í•‘ ë°©ì‹, ì£¼ì†Œ, ë¹„ë™ê¸? ?—¬ë¶?
 xhr.open('GET/POST/...', uri, true) // 1
 
 // 
 xhr.send // 2
 ```
 
