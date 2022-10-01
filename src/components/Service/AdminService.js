import axios from 'axios';

const baseUrl = "http://localhost:8080/admin/";

class AdminService {
    async getAdminLogin(login)
    {
        return await axios.post(baseUrl+"login",login)
    }

    async getAdminInfo(id)
    {
        return await axios.get(baseUrl+"admindetails/"+id)
    }

    async getAllStaffList()
    {
        return await axios.get(baseUrl+"stafflist")
    }

    async getAllManagerList()
    {
        return await axios.get(baseUrl+"managerlist")
    }

    async registerStaff(staff)
    {
        return await axios.post(baseUrl+"register/staff",staff);
    }

    async registerManager(manager)
    {
        return await axios.post(baseUrl+"register/manager",manager)
    }

    async roomList()
    {
        return await axios.get(baseUrl+"roomlist");
    }

    async updateRoomDetails(id,room)
    {
        return await axios.post(baseUrl+"updateroom/"+id,room)
    }

    async getRoomInfo(id)
    {
        return await axios.get(baseUrl+"roomlist/"+id);
    }

    async addRoom(room)
    {
        return await axios.post(baseUrl+"addroom",room);
    }

    async addShift(shift)
    {
        return await axios.post(baseUrl+"addshift",shift)
    }

    async getShiftInfo(id)
    {
        return await axios.get(baseUrl+"shiftlist/"+id);
    }

    async updateShift(id,shift)
    {
        return await axios.post(baseUrl+"updateshift/"+id,shift)
    }

    async shiftList()
    {
        return await axios.get(baseUrl+"shiftlist")
    }

    async getStaffDetails(id)
    {
        return await axios.get(baseUrl+"stafflist/"+id);
    }

    async removeEmployee(id)
    {
        return await axios.get(baseUrl+"removeemployee/"+id)
    }
}

export default new AdminService();