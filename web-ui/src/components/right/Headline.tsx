import {useContext, useRef, useState} from "react";
import {globalContext} from "../../App";
import {updateGroup} from "../../api/api";

export default function Headline() {
    const {currentGroup, setCurrentGroup, triggerUpdate} = useContext(globalContext)
    const [onEdit, setOnEdit] = useState<boolean>(false)
    const inputRef = useRef<HTMLInputElement>(null)
    const triggerEditHandler = () => {
        if (currentGroup.id === 0) return
        setOnEdit(true)
        setTimeout(()=> {
            inputRef.current && (inputRef.current.value = currentGroup.name)
            inputRef.current?.focus()
        }, 100)
    }

    const handleEdit = () => {
        setOnEdit(false)
        const newName = inputRef.current?.value as string
        if (newName.trim().length !== 0 && newName !== currentGroup.name) {
            updateGroup({
                id : currentGroup.id,
                name : newName.trim()
            }).then(res => res.data)
                .then(res => {
                    if (res.code === 200) {
                        setCurrentGroup({
                            ...currentGroup,
                            name : newName
                        })
                        triggerUpdate()
                    }
                })
        }
    }
    return (
        <div className="headline"><img src="/img/vite.svg"/>
            <input style={onEdit ? {} : {display : "none"}} ref={inputRef} onBlur={handleEdit} onKeyDown={(e) => e.key === "Enter" && handleEdit()}/>
            <span style={onEdit ? {display: "none"} : {}} onClick={triggerEditHandler}>{currentGroup.name}</span>
        </div>
    )
}