import Switch from "../common/Switch";
import Task from "../../type/Task";
import {useContext, useEffect, useState} from "react";
import {globalContext} from "../../App";
import {allGroup, updateTask} from "../../api/api";
import Group from "../../type/Group";

type Props = {
    task : Task
    cancel : () => void
}

export default function TaskDialog(props : Props) {
    const [name, setName] = useState<string>(props.task.name)
    const [description, setDescription] = useState<string>(props.task.description)
    const [completed, setCompleted] = useState<boolean>(props.task.completed)
    const [star, setStar] = useState<boolean>(props.task.star)
    const [groupId, setGroupId] = useState<number>(props.task.groupId)
    const [groupList, setGroupList] = useState<Group[]>([])

    const {triggerUpdate, updateFlag} = useContext(globalContext)

    const updateHandler = () => {
        if (name.trim().length === 0) return
        updateTask({
            id: props.task.id,
            name,
            description,
            completed,
            star,
            groupId
        }).then(res => res.data)
            .then(res => {
                if (res.code === 200) {
                    triggerUpdate()
                    props.cancel()
                } else console.error(res.msg)
            })
    }

    const warningStyle = name.trim().length === 0 ? {
        border: '1px solid red'
    } : {}

    const loadGroupList = () => {
        allGroup().then(res => res.data)
            .then(res => {
                if (res.code === 200) setGroupList([{id: 0, name: "默认分组"}, ...res.data])
                else console.log(res.msg)
            })
    }
    const handleChangeGroupOption = (id: number) => {
        for (let i in groupList) {
            if (groupList[i].id === id) {
                const group : Group = groupList.splice(Number(i), 1)[0]
                groupList.unshift(group)
                setGroupList(groupList)
                setGroupId(id)
            }
        }
    }
    useEffect(loadGroupList, [updateFlag])

    const groupOptions = groupList.map(item => <li onClick={() => handleChangeGroupOption(item.id)} key={item.id}>{item.name}</li>)
    return (
        <div className="updateDialog">
            <div>
                <label>任务组：</label>
                <ul>
                    {groupOptions}
                </ul>
            </div>
            <div>
                <label>任务名：</label>
                <input value={name} onChange={e => setName(e.target.value)} style = {warningStyle}/>
            </div>
            <div>
                <label>描述：</label>
                <input value={description ? description : ''} onChange={e => setDescription(e.target.value)}/>
            </div>
            <div>
                <label>完成：</label>
                <Switch status={completed} changeStatus={() => setCompleted(!completed)}/>
            </div>
            <div>
                <label>星标：</label>
                <Switch status={star} changeStatus={() => setStar(!star)}/>
            </div>
            <div>
                <button onClick={updateHandler}>更 新</button>
                <button onClick={props.cancel}>取 消</button>
            </div>
        </div>
    )
}