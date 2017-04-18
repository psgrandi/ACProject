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

## **Test** 
I had trouble to configure unit tests using Spring (with Java class Config) and Jersey configurations.
When a spring configuration was set, Jersey broke, and when Jersey configuration was set, Spring didn't work.

After some research, I found some frameworks that uses Spring XML configuration and not Java Class configuration (this project was created using Java Class configuration).

In that research, I found this post on Jira that treats this issue:

*https://java.net/jira/browse/JERSEY-2038*

Maybe there's a way to make this work, I'll keep searching...

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

### **API** ###

*Get all products excluding relationships (child products, images):*
```
/acode/api/product/getProducts
```

*Get product by id excluding relationships (child products, images):*
```
/acode/api/product/getProducts/{id}
```

*Get all products including specified relationships (child product and/or images):*
```
/acode/api/product/getCompleteProducts
```

*Get product by id including specified relationships (child product and/or images):*
```
/acode/api/product/getCompleteProducts/{id}
```

*Get set of child products for specific product:*
```
/acode/api/product/{id}/getChildren
```

*Get set of images for specific product:*
```
/acode/api/product/{id}/getImages
```