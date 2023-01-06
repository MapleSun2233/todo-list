import axios from 'axios'
import UpdateGroup from "../type/UpdateGroup";
import AddTask from "../type/AddTask";
import MarkTask from "../type/MarkTask";
import Task from "../type/Task";

const BASE_URL = '/api'

export async function allGroup() {
    return await axios.get(`${BASE_URL}/group`)
}

export async function allTask() {
    return await axios.get(`${BASE_URL}/task`)
}

export async function completedTask() {
    return await axios.get(`${BASE_URL}/task/completed`)
}

export async function uncompletedTask() {
    return await axios.get(`${BASE_URL}/task/uncompleted`)
}
export async function starTask() {
    return await axios.get(`${BASE_URL}/task/star`)
}

export async function allTaskByGroupId(id : number) {
    return await axios.get(`${BASE_URL}/task/group/${id}`)
}

export async function defaultGroupTaskCount() {
    return await axios.get(`${BASE_URL}/task/analysisDefaultGroupTask`)
}


export async function markTaskCompletedStatus(data : MarkTask) {
    return await axios.put(`${BASE_URL}/task/mark`, data)
}

export async function updateTaskStarStatus(data : MarkTask) {
    return await axios.put(`${BASE_URL}/task/star`, data)
}

export async function addGroup(name : string) {
    return await axios.post(`${BASE_URL}/group/${name}`)
}

export async function addTask(data : AddTask) {
    return await axios.post(`${BASE_URL}/task`, data)
}

export async function updateGroup(data : UpdateGroup) {
    return await axios.put(`${BASE_URL}/group`, data)
}
export async function deleteGroup(id : number) {
    return await axios.delete(`${BASE_URL}/group/${id}`)
}
export async function deleteTask(id : number) {
    return await axios.delete(`${BASE_URL}/task/${id}`)
}

export async function updateTask(data : Task) {
    return await axios.put(`${BASE_URL}/task`, data)
}

