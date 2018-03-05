package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "accountDetails")
public class AccountDetails {

	
	 	@Id
	    @Column(name = "id")
	    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "details_seq")
	    @SequenceGenerator(name = "details_seq", sequenceName = "details_seq", allocationSize = 1)
	    private Long id;

	    @Column(name = "firstName", length = 50)
	    @NotNull
	    @Size(min = 4, max = 50)
	    private String firstName;

	    @Column(name = "lastName", length = 50)
	    @NotNull
	    @Size(min = 4, max = 100)
	    private String lastName;

	    @Column(name = "contactNumber", length = 12)
	    @NotNull
	    @Size(min = 8, max = 10)
	    private String contactNumber;
	    
	    @Column(name = "address", length = 255)
	    @NotNull
	    @Size(min = 8, max = 10)
	    private String address;
	    

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getContactNumber() {
			return contactNumber;
		}

		public void setContactNumber(String contactNumber) {
			this.contactNumber = contactNumber;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		@Override
		public String toString() {
			return "AccountDetails [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
					+ ", contactNumber=" + contactNumber + ", address=" + address + "]";
		}

	    
	   
}
