import React,{useEffect} from 'react';

const Logout =()=>
{

    const log =  window.localStorage.getItem("isLoggedIn");

    useEffect(()=>
    {
        window.localStorage.setItem("isLoggedIn",false);
        window.localStorage.removeItem("usertype");
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