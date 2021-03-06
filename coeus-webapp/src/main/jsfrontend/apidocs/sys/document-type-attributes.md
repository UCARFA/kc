## Document Type Attributes [/research-sys/api/v1/document-type-attributes/]

### Get Document Type Attributes by Key [GET /research-sys/api/v1/document-type-attributes/(key)]
	 
+ Request

    + Headers

            Authorization: Bearer {api-key}
            Content-Type: application/json

+ Response 200
    + Headers

            Content-Type: application/json;charset=UTF-8

    + Body
    
            {"id": "(val)","ruleAttributeId": "(val)","documentTypeId": "(val)","orderIndex": "(val)","_primaryKey": "(val)"}

### Get All Document Type Attributes [GET /research-sys/api/v1/document-type-attributes/]
	 
+ Request

    + Headers

            Authorization: Bearer {api-key}
            Content-Type: application/json

+ Response 200
    + Headers

            Content-Type: application/json;charset=UTF-8

    + Body
    
            [
              {"id": "(val)","ruleAttributeId": "(val)","documentTypeId": "(val)","orderIndex": "(val)","_primaryKey": "(val)"},
              {"id": "(val)","ruleAttributeId": "(val)","documentTypeId": "(val)","orderIndex": "(val)","_primaryKey": "(val)"}
            ]

### Get All Document Type Attributes with Filtering [GET /research-sys/api/v1/document-type-attributes/]
    
+ Parameters

    + id (optional) - 
    + ruleAttributeId (optional) - 
    + documentTypeId (optional) - 
    + orderIndex (optional) - 

            
+ Request

    + Headers

            Authorization: Bearer {api-key}
            Content-Type: application/json 

+ Response 200
    + Headers

            Content-Type: application/json;charset=UTF-8

    + Body
    
            [
              {"id": "(val)","ruleAttributeId": "(val)","documentTypeId": "(val)","orderIndex": "(val)","_primaryKey": "(val)"},
              {"id": "(val)","ruleAttributeId": "(val)","documentTypeId": "(val)","orderIndex": "(val)","_primaryKey": "(val)"}
            ]
			
### Get Schema for Document Type Attributes [GET /research-sys/api/v1/document-type-attributes/]
	                                          
+ Parameters

      + _schema (required) - will instruct the endpoint to return a schema data structure for the resource
      
+ Request

    + Headers

            Authorization: Bearer {api-key}
            Content-Type: application/json

+ Response 200
    + Headers

            Content-Type: application/json;charset=UTF-8

    + Body
    
            {"columns":["id","ruleAttributeId","documentTypeId","orderIndex"],"primaryKey":"id"}
		
### Get Blueprint API specification for Document Type Attributes [GET /research-sys/api/v1/document-type-attributes/]
	 
+ Parameters

     + _blueprint (required) - will instruct the endpoint to return an api blueprint markdown file for the resource
                 
+ Request

    + Headers

            Authorization: Bearer {api-key}
            Content-Type: text/markdown

+ Response 200
    + Headers

            Content-Type: text/markdown;charset=UTF-8
            Content-Disposition:attachment; filename="Document Type Attributes.md"
            transfer-encoding:chunked
### Update Document Type Attributes [PUT /research-sys/api/v1/document-type-attributes/(key)]

+ Request

    + Headers

            Authorization: Bearer {api-key}   
            Content-Type: application/json

    + Body
    
            {"id": "(val)","ruleAttributeId": "(val)","documentTypeId": "(val)","orderIndex": "(val)","_primaryKey": "(val)"}
			
+ Response 204

### Update Multiple Document Type Attributes [PUT /research-sys/api/v1/document-type-attributes/]

+ Request

    + Headers

            Authorization: Bearer {api-key}   
            Content-Type: application/json

    + Body
    
            [
              {"id": "(val)","ruleAttributeId": "(val)","documentTypeId": "(val)","orderIndex": "(val)","_primaryKey": "(val)"},
              {"id": "(val)","ruleAttributeId": "(val)","documentTypeId": "(val)","orderIndex": "(val)","_primaryKey": "(val)"}
            ]
			
+ Response 204
### Insert Document Type Attributes [POST /research-sys/api/v1/document-type-attributes/]

+ Request

    + Headers

            Authorization: Bearer {api-key}   
            Content-Type: application/json

    + Body
    
            {"id": "(val)","ruleAttributeId": "(val)","documentTypeId": "(val)","orderIndex": "(val)","_primaryKey": "(val)"}
			
+ Response 201
    
    + Body
            
            {"id": "(val)","ruleAttributeId": "(val)","documentTypeId": "(val)","orderIndex": "(val)","_primaryKey": "(val)"}
            
### Insert Multiple Document Type Attributes [POST /research-sys/api/v1/document-type-attributes/]

+ Request

    + Headers

            Authorization: Bearer {api-key}   
            Content-Type: application/json

    + Body
    
            [
              {"id": "(val)","ruleAttributeId": "(val)","documentTypeId": "(val)","orderIndex": "(val)","_primaryKey": "(val)"},
              {"id": "(val)","ruleAttributeId": "(val)","documentTypeId": "(val)","orderIndex": "(val)","_primaryKey": "(val)"}
            ]
			
+ Response 201
    
    + Body
            
            [
              {"id": "(val)","ruleAttributeId": "(val)","documentTypeId": "(val)","orderIndex": "(val)","_primaryKey": "(val)"},
              {"id": "(val)","ruleAttributeId": "(val)","documentTypeId": "(val)","orderIndex": "(val)","_primaryKey": "(val)"}
            ]
### Delete Document Type Attributes by Key [DELETE /research-sys/api/v1/document-type-attributes/(key)]
	 
+ Request

    + Headers

            Authorization: Bearer {api-key}
            Content-Type: application/json

+ Response 204

### Delete All Document Type Attributes [DELETE /research-sys/api/v1/document-type-attributes/]

+ Parameters

      + _allowMulti (boolean, required) - flag to allow multiple resources to be deleted in one operation

+ Request

    + Headers

            Authorization: Bearer {api-key}
            Content-Type: application/json

+ Response 204

### Delete All Document Type Attributes with Matching [DELETE /research-sys/api/v1/document-type-attributes/]

+ Parameters

    + _allowMulti (boolean, required) - flag to allow multiple resources to be deleted in one operation
    + id (optional) - 
    + ruleAttributeId (optional) - 
    + documentTypeId (optional) - 
    + orderIndex (optional) - 

      
+ Request

    + Headers

            Authorization: Bearer {api-key}
            Content-Type: application/json

+ Response 204
