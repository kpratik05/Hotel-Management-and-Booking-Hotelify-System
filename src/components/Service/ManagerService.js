import axios from 'axios';

const baseUrl = "http://localhost:8080/manager/";

class ManagerService{

    async getFromLogin(login)
    {
        console.log(login.id+" "+login.password)
        return await axios.post(baseUrl+"login",login);
    }

    getManagerInfo(id)
    {
        return axios.get(baseUrl+"profile/"+id);
    }

    getManagerLoginList(id)
    {
        return axios.get(baseUrl+"managerlogin/"+id);
    }

    updateManagerDetails(manager)
    {
        return axios.post(baseUrl+"update",manager);
    }

    getStaffList(deptId)
    {
        return axios.get(baseUrl+"stafflist/"+deptId);
    }

    getEmployeeDetails(id)
    {
        return axios.get(baseUrl+"employeedetails/"+id)
    }

    getEmployeeDepartment(id)
    {
        return axios.get(baseUrl+"stafflist/"+id)
    }

    getFeedbackOfStaff(id)
    {
        console.log(id);
        return axios.get(baseUrl+"employeefeedback/employee/"+id);
    }

    addFeedback(fdback)
    {   
        console.log("service "+fdback.staff);
        return axios.post(baseUrl+"addfeedback/"+fdback.staff,fdback);
    }

    getCustomerPaymnetList()
    {
        return axios.get(baseUrl+"customerpayment");
    }

    getAllFeedback(id)
    {
        return axios.get(baseUrl+"employeefeedbacklist/"+id)
    }

    changeShift(staff)
    {
        console.log("Staff Id = "+staff.employeeId)
        return axios.post(baseUrl+"assignshift/"+staff.employeeId,staff)
    }

    bookRoom(id,booking)
    {
        return axios.post(baseUrl+"bookroom/"+id,booking)
    }
}

export default new ManagerService();