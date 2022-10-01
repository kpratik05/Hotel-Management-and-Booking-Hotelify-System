import ManagerProfile from "./components/Profile/ManagerProfile";
import Header from "./components/Header/Header";
import Homebody from "./components/Homebody/Homebody";
import Homedetails from "./components/Hoteldetails/Hotedetails";
import Hotelcontact from "./components/HotelContact/Hotelcontact";
import Services from "./components/Services/Services";
import Login from "./components/Login/Login";
import Stafflogin from "./components/Login/Stafflogin";
import Managerlogin from "./components/Login/Managerlogin";
import Rooms from "./components/Room/Rooms";
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
import CustomerPaymnetList from "./components/CustomerList/CustomerPaymentList";
import CustomerBooking from "./components/CustomerList/CustomerBooking";
import StaffAllFeedback from "./components/Feedback/StaffAllFeedback";
import Adminlogin from "./components/Login/Adminlogin";
import StaffAllList from "./components/StaffList/StaffAllList"
import ManagerAllList from "./components/StaffList/ManagerAllList";
import AdminProfile from "./components/Profile/AdminProfile";
import RegisterStaff from "./components/Register/RegisterStaff"
import RegisterManager from "./components/Register/RegisterManager";
import RoomList from "./components/Room/RoomList";
import UpdateRoom from "./components/Updates/UpdateRoom";
import AddRoom from "./components/Register/AddRoom";
import AddShift from "./components/Register/AddShift";
import UpdateShift from "./components/Updates/UpdateShift";
import ShiftList from "./components/Shift/ShiftList";
import AdminEmployeeInfo from "./components/EmployeeDetails/AdminEmployeeInfo";
import RemoveStaff from "./components/EmployeeDetails/RemoveStaff";
import CustomerProfile from "./components/Profile/CustomerProfile";
import SpecCustBooking from "./components/Booking/SpecCustBooking";
import RegisterCustomer from "./components/Register/RegisterCustomer";
import CustomerUpdate from "./components/Updates/CustomerUpdate";
import EmployeeChangeShift from "./components/EmployeeDetails/EmployeeChangeShift";
import PaymentFirst from "./components/Payment/PaymentFirst";
import CusOwnPaymnetList from "./components/CustomerList/CusOwnPaymentList";
import ThankYou from "./components/Payment/ThankYou";
import StaffProfile from "./components/Profile/StaffProfile";
import StaffUpdate from "./components/Updates/StaffUpdate";
import RoomDetailsEmp from "./components/Room/RoomDetailsEmp";
import { Fragment, useState } from "react";
import ShiftDetails from "./components/Shift/ShiftDetails";
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import RoomDetails from "./components/Room/RoomDetails";

function App() {

  const [dates,setDates] = useState({
        checkInDate:'',
        checkOutDate:'',
        sort:1,
        roomType:1
  }) 

  const addDates=(ob)=>{
    setDates(ob);
  }


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
        <Route exact path="/rooms" render={(props)=>(<Rooms {...props} addDateHandler={addDates} ></Rooms>)} />
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

        <Route exact path="/manager/customerpayment" component={CustomerPaymnetList} />
        <Route exact path="/manager/bookinglist" component={CustomerBooking} />
        <Route exact path="/manager/feedbacklist" component={StaffAllFeedback} />
        <Route exact path="/admin/stafflist" component={StaffAllList} />
        <Route exact path="/admin/managerlist" component={ManagerAllList} />
        <Route exact path="/adminlogin" component={Adminlogin} />
        <Route exact path="/admin/profile" component={AdminProfile} />
        <Route exact path="/admin/customerpayment" component={CustomerPaymnetList} />
        <Route exact path="/admin/bookinglist" component={CustomerBooking} />
        <Route exact path="/admin/registerstaff" component={RegisterStaff} />
        <Route exact path="/admin/registermanager" component={RegisterManager} />
        <Route exact path="/admin/roomlist" component={RoomList} />
        <Route exact path="/admin/updateroom/:rId" component={UpdateRoom} />
        <Route exact path="/admin/addroom" component={AddRoom} />
        <Route exact path="/admin/shiftlist" component={ShiftList} />
        <Route exact path="/admin/addshift" component={AddShift} />
        <Route exact path="/admin/updateshift/:id" component={UpdateShift} />
          <Route exact path="/admin/removestaff/:id" component={RemoveStaff} />
          <Route exact path="/customer/profile" component={CustomerProfile} />
          <Route exact path="/customer/history/:id" component={SpecCustBooking} />
          <Route exact path="/customerregister" component={RegisterCustomer} />        
          <Route exact path="/customer/update/:id" component={CustomerUpdate} />  
          <Route exact path="/rooms/:id" render={(props)=>(<RoomDetails {...props} details={dates} ></RoomDetails>)} />    

        <Route exact path="/admin/staffdetails/:id">
        <Fragment>
            <AdminEmployeeInfo></AdminEmployeeInfo>
            <StaffLoginList></StaffLoginList>
        </Fragment>
        </Route>

        <Route exact path="/manager/setshift/:id" component={EmployeeChangeShift} />
        <Route exact path="/manager/payment" component={PaymentFirst} />
        <Route exact path="/staff/payment" component={PaymentFirst} />
        <Route exact path="/customer/payment/:id" component={CusOwnPaymnetList} />
        <Route exact path="/thankyou" component={ThankYou} />

        <Route exact path="/staff/profile" component={StaffProfile} />
        <Route exact path="/staff/update" component={StaffUpdate} />
        <Route exact path="/customer/payment" component={PaymentFirst} />
        <Route exact path="/shift/:id" component={ShiftDetails} />
        <Route exact path="/emp/roomdetails/:id" render={(props)=>(<RoomDetailsEmp {...props} details={dates} ></RoomDetailsEmp>)} />
      </Switch>
    </div>
    </Router>
  );
}

export default App;
