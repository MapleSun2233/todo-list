import TaskList from "./TaskList";
import Headline from "./Headline";
import CommonAdd from "../common/CommonAdd";
import {useContext} from "react";
import {globalContext} from "../../App";
import {addTask} from "../../api/api";

export default function Right() {
    const {triggerUpdate, currentGroup} = useContext(globalContext)
    const addTaskAction = (name : string) => {
        addTask({
            groupId : currentGroup.id,
            name
        }).then(res => res.data)
            .then(res => {
                if(res.code === 200) triggerUpdate()
                else console.error(res.msg)
            })
    }
    return (
        <div className="right">
            <Headline/>
            <TaskList/>
            <CommonAdd placeholder="添加任务..." addAction={addTaskAction}/>
        </div>
    )
}