import Position from "./Position";

type ContextMenuParam = {
    show : boolean
    position : Position
    callback : () => void
}

export default ContextMenuParam