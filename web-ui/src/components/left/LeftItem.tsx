import {MouseEventHandler, useContext} from "react";
import {globalContext} from "../../App";
import Group from "../../type/Group";
import {deleteGroup} from "../../api/api";

type Props = {
    group : Group
}
export default function LeftItem(props : Props) {
    const {currentGroup, setCurrentGroup, showContextMenu, triggerUpdate} = useContext(globalContext)
    const isActive = () : boolean => {
        if (currentGroup.id === 0 && props.group.id === 0)
            return currentGroup.label === props.group.label
        else return currentGroup.id === props.group.id
    }

    const contextMenuHandler : MouseEventHandler<HTMLDivElement> = (e) => {
        e.preventDefault()
        if (props.group.id !== 0) {
            showContextMenu({
                x : e.pageX,
                y : e.pageY
            }, () => {
                deleteGroup(props.group.id)
                    .then(res => res.data)
                    .then(res => {
                        if (res.code === 200) triggerUpdate()
                        else console.error(res.msg)
                    })
            })
        }
    }
    return (
        <div className={`leftItem ${isActive() ? 'active' : ''}`} onClick={() => setCurrentGroup(props.group)} onContextMenu={contextMenuHandler}>
            <img src="/img/vite.svg" alt="icon"/>
            <span>{props.group.name}</span>
            {props.group.num > 0 && <span>{props.group.num}</span>}
        </div>
    )
}