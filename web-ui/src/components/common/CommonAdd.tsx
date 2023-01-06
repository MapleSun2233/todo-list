import {KeyboardEventHandler} from "react";

type Props = {
    placeholder : string
    addAction : (name : string) => void
}

declare interface InputEventTarget extends EventTarget {
    value : string
}

export default function CommonAdd(props : Props) {
    const enterHandler : KeyboardEventHandler<HTMLInputElement> = (e) => {
        if (e.key === 'Enter') {
            const target = e.target as InputEventTarget
            if (target.value.trim().length === 0) return
            props.addAction(target.value.trim())
            target.value = ""
        }
    }
    return (
        <div className="commonAdd">
            <input placeholder={props.placeholder} onKeyDown={enterHandler}/>
        </div>
    )
}