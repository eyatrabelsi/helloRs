package entities;

import javax.xml.bind.annotation.XmlElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "entité enregistré dans swagger")
public class Employee {
private String cin;
private String firstname;
private String lastname;

public Employee() {
	
}
public Employee(String cin, String firstname, String lastname) {
	super();
	this.cin = cin;
	this.firstname = firstname;
	this.lastname = lastname;
}
@XmlElement(name="cin")
@ApiModelProperty(value ="getCin")
public String getCin() {
	return cin;
}
public void setCin(String cin) {
	this.cin = cin;
}
@XmlElement(name="firstname")
@ApiModelProperty(value ="getFirstname")
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
@XmlElement(name="lastname")
@ApiModelProperty(value ="getLastname")
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}


}
