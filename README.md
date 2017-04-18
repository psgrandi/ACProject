# **AC Project**

Rest Application using:

* Jersey 2
* Spring 4
* Hibernate 5
* Derby In Memory DB

## **Build**

```
mvn clean install
```

## **Run** 

```
mvn jetty:run
```

## **Services** ##
All services consume and produce JSONs
### **CRUD** ###

*Add new product:*
```
/acode/crud/product/add
```

```
#!json

{"name":"box of chocolates", 
 "description":"box of chocolates " ,
 "images": [{"type":"COVER"}]
}
```

*Add new child product:*
```
/acode/crud/product/{parentId}/addChild
```

```
#!json

{"name":"milk chocolate", 
 "description":"milk chocolate" ,
 "images": [{"type":"COVER"}]
}
```

*Add new image to a product:*
```
/acode/crud/product/{productId}/image/add
```

```
#!json

{"type":"COVER"}
```

*Update product:*
```
/acode/crud/product/update/{id}
```

```
#!json

{"name":"dark chocolate", 
 "description":"dark chocolate" ,
 "images": [{"type":"COVER"}]
}
```

*Update image:*
```
/acode/crud/image/update/{id}
```

```
#!json

{"type":"PROFILE"}
```

*Delete product:*
```
/acode/crud/product/delete/{id}
```

*Delete Image:*
```
/acode/crud/image/delete/{id}
```