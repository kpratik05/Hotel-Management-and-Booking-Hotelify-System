import React,{useEffect} from 'react';
import { useHistory } from 'react-router-dom';

const Logout =()=>
{
    const history = useHistory(); 
    const log =  window.localStorage.getItem("isLoggedIn");

    useEffect(()=>
    {
        window.localStorage.setItem("isLoggedIn",false);
        window.localStorage.removeItem("usertype");
        setTimeout(()=>{
            history.push("/");
        },5000)
    },[])

    return(
        <div>
        {
           log=="false"?
            <div>
                <h3>Logged out successfully</h3>
            </div>
            :
            <div>
                <h3>Some problem while loggint out</h3>
                </div>
        }
        </div>
    )
}

export default Logout;