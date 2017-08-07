package org.kuali.coeus.sys.framework.auth;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CategoryDto {

	private String id;
	private String parentId;
	private String name;
	private List<RoleSchemaDto> roleSchemas = new ArrayList<>();
	private List<FieldSchemaDto> fieldSchemas = new ArrayList<>();
	
	@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
	public static final class RoleSchemaDto {
		private String id;
		private String name;
		private String description;
		
		public RoleSchemaDto() {
			
		}
		public RoleSchemaDto(String id, String name) {
			this.id = id;
			this.name = name;
		}
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		
		@Override
		public String toString() {
			return new ToStringBuilder(this)
				.append(id)
				.append(name)
				.append(description)
				.toString();
		}
	}
	
	public static final class FieldSchemaDto {
		private String id;
		private String type;
		private String name;
		public FieldSchemaDto() {
			
		}
		public FieldSchemaDto(String id, String type, String name) {
			this.id = id;
			this.type = type;
			this.name = name;
		}
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		@Override
		public String toString() {
			return new ToStringBuilder(this)
				.append(id)
				.append(type)
				.append(name)
				.toString();
		}
	}

	@JsonIgnore
	public String getId() {
		return id;
	}

	@JsonProperty
	public void setId(String id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<RoleSchemaDto> getRoleSchemas() {
		return roleSchemas;
	}

	public void setRoleSchemas(List<RoleSchemaDto> roleSchemas) {
		this.roleSchemas = roleSchemas;
	}

	public List<FieldSchemaDto> getFieldSchemas() {
		return fieldSchemas;
	}

	public void setFieldSchemas(List<FieldSchemaDto> fieldSchemas) {
		this.fieldSchemas = fieldSchemas;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append(id)
			.append(parentId)
			.append(name)
			.append(fieldSchemas)
			.append(roleSchemas)
			.toString();
	}
}
