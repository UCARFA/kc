package org.kuali.coeus.sys.framework.auth;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class GroupDto {

	private String id;
	private String parentId;
	private String name;
	private String categoryId;
	private List<GroupFields> fields = new ArrayList<>();
	private List<Role> roles = new ArrayList<>();
	
	public static final class GroupFields {
		private String id;
		private String value;
		
		public GroupFields() {
			
		}
		public GroupFields(String id, String value) {
			this.id = id;
			this.value = value;
		}
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		
		@Override
		public String toString() {
			return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
				.append("id", id)
				.append("value", value)
				.toString();
		}
	}
	
	public static final class Role {
		private String id;
		private List<String> value;
		
		public Role() {
			
		}
		public Role(String id, List<String> value) {
			this.id = id;
			this.value = value;
		}
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public List<String> getValue() {
			return value;
		}
		public void setValue(List<String> value) {
			this.value = value;
		}
		
		@Override
		public String toString() {
			return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
				.append("id", id)
				.append("value", value)
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

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public List<GroupFields> getFields() {
		return fields;
	}

	public void setFields(List<GroupFields> fields) {
		this.fields = fields;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
			.append("id", id)
			.append("name", name)
			.append("parentId", parentId)
			.append("categoryId", categoryId)
			.append("fields", fields)
			.toString();
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
