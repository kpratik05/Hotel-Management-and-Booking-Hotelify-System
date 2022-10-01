import React from "react";
import { useHistory } from "react-router-dom";

const ThankYou =()=>{

    const history = useHistory();

    setTimeout(()=>{
        history.push("/");
    },3000)

    return(
        <h3>
            Thank you for visiting, See you soon
        </h3>
    )

}

export default ThankYou;