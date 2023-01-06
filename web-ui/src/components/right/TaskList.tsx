import TaskItem from "./TaskItem";
import {useContext, useEffect, useState} from "react";
import {globalContext} from "../../App";
import Task from "../../type/Task";
import {allTask, allTaskByGroupId, completedTask, starTask, uncompletedTask} from "../../api/api";
import TaskDialogParam from "../../type/TaskDialogParam";
import TaskDialog from "./TaskDialog";

export default function TaskList() {
    // state
    const {currentGroup, updateFlag} = useContext(globalContext)
    const [list, setList] = useState<Task[]>([])
    const [taskDialogParams, setTaskDialogParams] = useState<TaskDialogParam>({
        show: false,
        task: {
            id: 0,
            name: "",
            description: "",
            completed: false,
            star: false,
            groupId: 0
        }
    })
    // action
    const getDefaultGroupTask = () => {
        switch (currentGroup.label) {
            case "all":
                return allTask()
            case "uncompleted":
                return uncompletedTask()
            case "completed":
                return completedTask()
            case "star":
                return starTask()
            default:
                return allTask()
        }
    }

    const loadDefaultGroupTask = () : void => {
        getDefaultGroupTask().then(res => res.data).then(res => setList(res.data))
    }

    const loadSelfGroupTask = () : void => {
        allTaskByGroupId(currentGroup.id).then(res => res.data).then(res => setList(res.data))
    }
    const load = () => {
        if (currentGroup.id === 0) {
            loadDefaultGroupTask()
            return
        }
        loadSelfGroupTask()
    }

    useEffect(load,[currentGroup, updateFlag])

    const showTaskDialog = (task : Task) => {
        setTaskDialogParams({
            show : true,
            task
        })
    }
    const cancelTaskDialog = () => {
        setTaskDialogParams({
            ...taskDialogParams,
            show : false
        })
    }

    // render
    const taskItems = list.map((item, key) => <TaskItem showDialog={showTaskDialog}  task={item} key={key}/>)
    const taskDialog = taskDialogParams.show && <TaskDialog task={taskDialogParams.task} cancel={cancelTaskDialog}/>
    return (
        <div className="taskList">
            {taskItems}
            {taskDialog}
        </div>
    )
}