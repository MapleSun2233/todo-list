import Group from "./Group";
import {Dispatch, SetStateAction} from "react";
import Position from "./Position";

type GlobalContext = {
    currentGroup : Group
    setCurrentGroup : Dispatch<SetStateAction<Group>>
    updateFlag : boolean
    triggerUpdate : () => void
    showContextMenu : (position : Position, callback : () => void) => void
}
export default GlobalContext