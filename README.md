# **AC Project**

Rest Application using:

* Jersey 2
* Spring 4
* Hibernate 5
* Derby In Memory DB
* JDK 1.7.0_80

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
HTTP Method: POST
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
HTTP Method: POST
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
HTTP Method: POST
/acode/crud/product/{productId}/image/add
```

```
#!json

{"type":"COVER"}
```

*Update product:*
```
HTTP Method: PUT
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
HTTP Method: PUT
/acode/crud/image/update/{id}
```

```
#!json

{"type":"PROFILE"}
```

*Delete product:*
```
HTTP Method: DELETE
/acode/crud/product/delete/{id}
```

*Delete Image:*
```
HTTP Method: DELETE
/acode/crud/image/delete/{id}
```

### **API** ###

*Get all products excluding relationships (child products, images):*
```
HTTP Method: GET
/acode/api/product/getProducts
```

*Get product by id excluding relationships (child products, images):*
```
HTTP Method: GET
/acode/api/product/getProducts/{id}
```

*Get all products including specified relationships (child product and/or images):*
```
HTTP Method: GET
/acode/api/product/getCompleteProducts
```

*Get product by id including specified relationships (child product and/or images):*
```
HTTP Method: GET
/acode/api/product/getCompleteProducts/{id}
```

*Get set of child products for specific product:*
```
HTTP Method: GET
/acode/api/product/{id}/getChildren
```

*Get set of images for specific product:*
```
HTTP Method: GET
/acode/api/product/{id}/getImages
```
