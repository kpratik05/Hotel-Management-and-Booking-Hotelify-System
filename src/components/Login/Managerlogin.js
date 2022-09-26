import React,{useState,useRef,useEffect} from 'react';
import ManagerService from "../Service/ManagerService";
import { useHistory} from 'react-router-dom';
import "./Login.css";

const Managerlogin =()=> {
    const history = useHistory();
    const [manager,setManager] = useState({
        name:"",
        email:"",
        address:"",
        mobileNo:0,
        password:"",
        birthDate:null,
        employeeId:0,
        department:null
    });
    const errRef = useRef();

    
    // const[id,setId] = useState({
    //     id:0
    // })

    // const[password,setPassword] = useState({
    //     password:''
    // })

    const [login, setLogin] = useState({
        id:0,
        password:""
    });
    const [errMsg, setErrMsg] = useState('');

    const {id,password} = login;

    const onInputChange = (e) =>{
        setLogin({...login,[e.target.name]:e.target.value})
    };

    useEffect(() => {
        setErrMsg('');
    }, [id, password])

    const handleSubmit = async(e) =>  {
        e.preventDefault();
        console.log("Manager login "+login.id+" "+login.password)

        
            await ManagerService.getFromLogin(login).then(response => {
                console.log("Info "+response.data.employeeId);
                 setManager(response.data);
                 
             }
            
               )
               .catch(function (ex) {
                  
            if (!ex?.response) {
                setErrMsg('No Server Response');
            } else if (ex.response?.status === 400) {
                setErrMsg('Missing Username or Password');
            } else if (ex.response?.status === 401) {
                setErrMsg('Unauthorized');
            } else {
                setErrMsg('Login Failed');
            }
            errRef.current.focus();
        }
               );

            console.log("employee id "+manager.employeeId+" "+manager.email);
                
               window.localStorage.setItem("isLoggedIn",true);
               window.localStorage.setItem("id",manager.employeeId);
               window.localStorage.setItem("usertype","manager");
               window.localStorage.setItem("deptId",manager.department.deptId);
            // history.push("/");
        }

    
        return (
            <div>
                
                <div class="card text-center">
                    <div class="card-header">
                        <ul class="nav nav-tabs card-header-tabs">
                            <li class="nav-item">
                                <a class="nav-link" href="/stafflogin">Staff login</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" href="/managerlogin">Manager login</a>
                            </li>
                        </ul>
                    </div>
                    <div class="card-body">
                    <p ref={errRef} className={errMsg ? "errmsg" : "offscreen"} aria-live="assertive">{errMsg}</p>
                        <form onSubmit= {handleSubmit}>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Employee Id</label>
                                <input type="number" class="form-control" id="exampleInputEmail1"  placeholder="Enter id" name="id" value={id} onChange={e => onInputChange(e)} />

                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1">Password</label>
                                <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="password" value={password} onChange={e => onInputChange(e)}/>
                            </div>
                            <div class="but">
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </div>
                        </form>
                    </div>
                </div>



            </div>
        )
}

export default Managerlogin;