import axios from 'axios';

const baseUrl = "http://localhost:8080/staff/";

class StaffService {
    async getFromLogin(login)
    {
        return await axios.post(baseUrl+"login",login)
    }

    async getStaffInfo(id)
    {
        return await axios.get(baseUrl+"profile/"+id)
    }

    async roomList()
    {
        return await axios.get(baseUrl+"roomlist");
    }

    async updateStaffDetails(staff)
    {
        return await axios.post(baseUrl+"update",staff);
    }

    async getShiftDetails(id)
    {
        return await axios.get(baseUrl+"shift/"+id);
    }
}
export default new StaffService();
