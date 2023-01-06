import Task from "../../type/Task";
import {deleteTask, markTaskCompletedStatus, updateTaskStarStatus} from "../../api/api";
import {MouseEventHandler, useContext} from "react";
import {globalContext} from "../../App";

type Props = {
    task : Task
    showDialog : (task : Task) => void
}
export default function TaskItem(props : Props) {

    const {triggerUpdate, showContextMenu} = useContext(globalContext)
    const updateCompletedStatus : MouseEventHandler<HTMLImageElement> = (e) => {
        e.stopPropagation()
        markTaskCompletedStatus({
            id : props.task.id,
            status : !props.task.completed
        }).then(res => res.data).then(res => res.code === 200 && triggerUpdate())
    }
    const updateStarStatus : MouseEventHandler<HTMLImageElement>= (e) => {
        e.stopPropagation()
        updateTaskStarStatus({
            id : props.task.id,
            status : !props.task.star
        }).then(res => res.data).then(res => res.code === 200 && triggerUpdate())
    }

    const contextMenuHandler : MouseEventHandler<HTMLDivElement> = (e) => {
        e.preventDefault()
        showContextMenu({
            x : e.pageX,
            y : e.pageY
        }, () => {
            deleteTask(props.task.id)
                .then(res => res.data)
                .then(res => {
                    if (res.code === 200) triggerUpdate()
                    else console.error(res.msg)
                })
        })
    }

    return (
        <div className="taskItem" onContextMenu={contextMenuHandler} onClick={() => props.showDialog(props.task)}>
            <img onClick={updateCompletedStatus} src={props.task.completed ? "/img/completed.svg" : "/img/uncompleted.svg"}/>
            <span>{props.task.name}</span>
            <img onClick={updateStarStatus} src={props.task.star ? "/img/star-fill.svg" : "/img/star.svg"}/>
        </div>
    )
}