import React,{useEffect,useState} from "react";
import { useHistory } from "react-router-dom";
import CustomerService from "../Service/CustomerService";
const CustomerUpdate =()=>
{

    const cId = window.localStorage.getItem("id");

    const history = useHistory();
    const [customer,setCustomer] = useState({
        name:"",
        email:"",
        address:"",
        mobileNo:0,
        password:"",
        birthDate:'',
        customerId:0,
    });

    const onInputChange = (e) =>{
        setCustomer({...customer,[e.target.name]:e.target.value})
    };

    const {customerId,name,email,address,mobileNo,password,birthDate} = customer;

    useEffect(() => {
        loadUser();
      }, []);

      const loadUser= async()=>
      {
        console.log("ID "+cId);
        CustomerService.getProfile(cId).then(response => {
            console.log("c profile response "+response.data.email);
            setCustomer(response.data);
            console.log("c name "+customer.name+" "+customer.customerId)
        }
        )
        .catch((err) => {
            if (err.response.statuscode == 400) {
                console.log(err);
            } else {
              console.log("something else");
            }
        });;
      }

      const onSubmit = async e => {
        e.preventDefault();
        CustomerService.updateCustomer(cId,customer).then(response => {
            console.log("c profile response "+response.data.email);
            setCustomer(response.data);
            console.log("c name "+customer.name+" "+customer.id)
        }
        )
        .catch((err) => {
            if (err.response.statuscode == 400) {
                console.log(err);
            } else {
              console.log("something else");
            }
        });;
        window.alert("Updated successfully !");
        history.push("/customer/profile");
      };

    return(
        <div>
        <form onSubmit= {onSubmit}>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Customer Id</label>
                                <input type="number" class="form-control" id="exampleInputEmail1" readOnly placeholder="Enter id" name="id" value={customerId} onChange={e => onInputChange(e)} />

                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1">Name</label>
                                <input type="text" class="form-control" id="exampleInputPassword1" placeholder="Name" name="name" value={name} onChange={e => onInputChange(e)}/>
                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1">Email</label>
                                <input type="text" class="form-control" id="exampleInputPassword1" placeholder="Email" name="email" value={email} onChange={e => onInputChange(e)}/>
                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1">Address</label>
                                <input type="text" class="form-control" id="exampleInputPassword1" placeholder="Address" name="address" value={address} onChange={e => onInputChange(e)}/>
                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1">Mobile No</label>
                                <input type="text" class="form-control" id="exampleInputPassword1" placeholder="Mobile No" name="mobileNo" value={mobileNo} onChange={e => onInputChange(e)}/>
                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1">Birth Date</label>
                                <input type="Date" class="form-control" id="exampleInputPassword1" placeholder="Birthdate" name="birthDate" value={birthDate} onChange={e => onInputChange(e)}/>
                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1">Password</label>
                                <input type="text" class="form-control" id="exampleInputPassword1" placeholder="Password" name="password" value={password} onChange={e => onInputChange(e)}/>
                            </div>
                            <div class="but">
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </div>
                        </form>
    </div>
    )
}

export default CustomerUpdate;