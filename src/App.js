import ManagerProfile from "./components/Profile/ManagerProfile";
import Header from "./components/Header/Header";
import Homebody from "./components/Homebody/Homebody";
import Homedetails from "./components/Hoteldetails/Hotedetails";
import Hotelcontact from "./components/HotelContact/Hotelcontact";
import Services from "./components/Services/Services";
import Login from "./components/Login/Login";
import Stafflogin from "./components/Login/Stafflogin";
import Managerlogin from "./components/Login/Managerlogin";
import Room from "./components/Room/Rooms";
import Servicedetails from "./components/Services/Servicedetails";
import Logout from "./components/Login/Logout";
import ManagerLoginList from "./components/Profile/ManagerLoginList";
import ManagerUpdate from "./components/Updates/ManagerUpdate";
import {BrowserRouter as Router,Link,Route,Switch} from 'react-router-dom';
import StaffList from "./components/StaffList/StaffList";
import StaffLoginList from "./components/Profile/StaffLoginList";
import EmployeeInfo from "./components/EmployeeDetails/EmployeeInfo";
import StaffFeedbackList from "./components/Feedback/StaffFeedbackList";
import AddFeedback from "./components/Feedback/AddFeedback";
import { Fragment } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';

function App() {


  return (
    <Router>
    <div className="App">
    <Header/>
      <Switch>
        <Route exact path="/hoteldetails" component={Homedetails}/>
        <Route exact path="/" component={Homebody} />
        <Route exact path="/contact" component={Hotelcontact} />
        <Route exact path="/services" component={Services} />
        <Route exact path="/login" component={Login} />
        <Route exact path="/stafflogin" component={Stafflogin}/>
        <Route exact path="/managerlogin" component={Managerlogin}/>
        <Route exact path="/rooms" component={Room} />
        <Route exact path="/services/:service" component={Servicedetails} />
        <Route exact path="/manager/profile" component={ManagerProfile} />
        <Route exact path="/logout" component={Logout}/>
        <Route exact path="/manager/stafflist" component={StaffList}/>
        <Route exact path="/manager/login" component={ManagerLoginList}/>
        <Route exact path="/manager/update" component={ManagerUpdate} />
        <Route exact path="/manager/feedback/:id" component={StaffFeedbackList}/>
        <Route exact path="/manager/addfeedback/:id" component={AddFeedback} />
        <Route exact path="/manager/staffdetails/:id">
        <Fragment>
            <EmployeeInfo></EmployeeInfo>
            <StaffLoginList></StaffLoginList>
        </Fragment>
        </Route>
      </Switch>
    </div>
    </Router>
  );
}

export default App;
