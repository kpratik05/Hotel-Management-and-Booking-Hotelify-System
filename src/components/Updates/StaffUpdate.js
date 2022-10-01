import React,{useEffect,useState} from "react";
import { useHistory } from "react-router-dom";
import StaffService from "../Service/StaffService";
const StaffUpdate =()=>
{

    const staffId = window.localStorage.getItem("id");

    const history = useHistory();
    const [staff,setStaff] = useState({
        name:"",
        email:"",
        address:"",
        mobileNo:0,
        password:"",
        birthDate:'',
        employeeId:0,
        department:'',
        shift: 0,
        role: 0
    });

    const onInputChange = (e) =>{
        setStaff({...staff,[e.target.name]:e.target.value})
    };

    const {employeeId,name,email,address,mobileNo,password,birthDate,department,shiftId,roleId} = staff;

    useEffect(() => {
        loadUser();
      }, []);

      const loadUser= async()=>
      {
        console.log("ID "+staffId);
        StaffService.getStaffInfo(staffId).then(response => {
            console.log("Staff profile response "+response.data.email);
            setStaff(response.data);
            console.log("Staff name "+staff.name+" "+staff.employeeId)
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
        staff.department = staff.department.deptId;
        staff.shift = staff.shift.shiftId;
        staff.role = staff.role.roleId;

        StaffService.updateStaffDetails(staff).then(response => {
            console.log("Staff profile response "+response.data.email);
            setStaff(response.data);
            console.log("Staff name "+staff.name+" "+staff.id)
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
        history.push("/staff/profile");
      };

    return(
        <div>
        <form onSubmit= {onSubmit}>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Employee Id</label>
                                <input type="number" class="form-control" id="exampleInputEmail1" readOnly placeholder="Enter id" name="id" value={employeeId} onChange={e => onInputChange(e)} />

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
                                <label for="exampleInputPassword1">Department (readOnly)</label>
                                <p>{department.deptName}</p>
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

export default StaffUpdate;