# SPRING_MVC ����

 **[������Ʈ����](������Ʈ-����)** /
 **[Maven](#Maven)** /
 **[Lombok](#Lombok)** /
 **[log4j](#Log4j)** /
 **[junit](#Junit)** /
 **[������ ����](������-����)** /
 **[SpringMVC](#SpringMVC)** /
 **[��Ʈ�ѷ�](��Ʈ�ѷ�)** <br>
 **[DB����](DB����)** /
 **[����](#����)** /
 **[REST](#REST)** /



## ������Ʈ ����
>![projectStandard](./img/������Ʈ������Ű��.png)	![projectStandard](./img/������Ʈ������Ű��.png)
>- src/main/java : �ڹ� �ڵ带 �ۼ��ϴ°� <br>	- src/main/java : �ڹ� �ڵ带 �ۼ��ϴ°� <br>
>- src/main/resources : �ڹ� �ڵ带 ������ �� �ʿ��� ���ϵ��� �����ϴ� ��	- src/main/resources : �ڹ� �ڵ带 ������ �� �ʿ��� ���ϵ��� �����ϴ� ��


>- src/test/java : �ۼ��� �ڹ� �ڵ��� �׽�Ʈ�� �ۼ� �ϴ°�	- src/test/java : �ۼ��� �ڹ� �ڵ��� �׽�Ʈ�� �ۼ� �ϴ°�
>- src/test/resources : �׽�Ʈ �ڵ带 ������ �� �ʿ��� ���ϵ��� �����ϴ� ��	- src/test/resources : �׽�Ʈ �ڵ带 ������ �� �ʿ��� ���ϵ��� �����ϴ� ��


>- src : �� �ڵ带 �ۼ��ϴ� �� 	- src : �� �ڵ带 �ۼ��ϴ� �� 
  - root-context.xml : ������ ������Ʈ ��ü ���� ����	  - root-context.xml : ������ ������Ʈ ��ü ���� ����
  - servlet-context.xml : DispatcherServlet�� �ڹ� �ڵ���� �ٷ� �� �ִ� ���� ��		  - servlet-context.xml : DispatcherServlet�� �ڹ� �ڵ���� �ٷ� �� �ִ� ���� ����
  
>- pom.xml : Maven ���� ����	- pom.xml : Maven ���� ����
>- target : ������ ������� ������Ʈ�� �̸� �� �� ����	- target : ������ ������� ������Ʈ�� �̸� �� �� ����
## Maven

## Lombok
  
## Log4j
 
## Junit
  
## ������ ����

## SpringMVC
 
## ��Ʈ�ѷ�

## DB����

## ����

## REST
 ### REST��
  - Mapping�̸����� URI�ǹ̸� ǥ��
	- �� ������ ���� �ý����� RESTful�̶�� �Ѵ�.
	- RESTful�� ������ �������� �� ������ �Ӹ��� �ƴ϶� ����� �۰��� ����� �� �ִ�
  - �ϳ��� URI�� ������ CRUD�� ��� ������ �� �ִ�.
  ```java
  @PostMapping // CREATE
  @GetMapping // READ
  @PutMapping // UPDATE(��ü)
  @PatchMapping // UPDATE(�Ϻ�)
  @DeleteMapping // DELETE
  ```
 ### �߰��� Maven
  - jackson-databind
  - jackson-dataformat-xml
  - gson

 ### ������̼�
 ```java
 @RestController
 public class RestSampleController {
 ```
- �Ϲ� ��Ʈ�ѷ��� �ٸ��� ��� ���������� �ʰ� �����͸� �ٷ� ��ȯ�ϴ� ��Ʈ�ѷ�
- �Ϲ� ��Ʈ�ѷ����� @ResposneBody ������̼��� ����� ������ ���� �ִ�.
```java
@PostMapping(value = "/employee/create",
            consumes = "application/json",
            produces = "text/plain; charset=UTF-8"
				)
public ResponseEntity<Employee> createEmployee(@RequestBody Employee new_emp) {
```
- Jackson-databind�� �Բ� ����ϸ� JSON �Ǵ� XML�� ���޵� �����͸� �����ϰ� VO�� ��ȯ���ش�.
## Ajax
  ### Asynchronous JavaScript and XML (or JSON) / ������ �񵿱� ���
 - �������� ��ȭ��Ű�� �����鼭 �� ������ ��û�� ������.
 - ���� ��û�� �����ϸ� readyState���� ���Ѵ�.
 - readyState�� 0-UNSET / 1-OPEND / 2-SEND / 3-LOADING / 4-DONE 
 
 ### ����
 ```javascript
 // ��û ��ü
 xhr = new XMLHttpRequest();
 
 // readtState ��ȭ �����̺�Ʈ
 xhr.onreadystatechange = function() {}
 
 // ���� ���, �ּ�, �񵿱� ����
 xhr.open('GET/POST/...', uri, true) // 1
 
 // 
 xhr.send // 2
 ```
 
