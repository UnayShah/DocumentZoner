import React, { Component } from "react";

const rectangle = {
    display: 'inline-block',
    width: 125,
    height: 200,
    margin: 10,
    border: '2px solid black',
    borderRadius: 10,
}
const rectangleTransparent = {
    display: 'inline-block',
    width: 200,
    height: 100,
    margin: 10,
    border: '0px solid black',
}
const doc = {
    width: 200,
    height: 400,
};

class Background extends Component {
    constructor(props) {
        super(props);
        this.state = { windowWidth: window.innerWidth, windowHeight: window.innerHeight }
        this.state = { countRow: this.state.windowHeight / doc.height, countColumn: this.state.windowWidth / doc.width };
    }

    handleResize = (e) => {
        this.setState({ windowWidth: window.innerWidth, windowHeight: window.innerHeight })
        this.setState({ countRow: this.state.windowHeight / doc.height, countColumn: this.state.windowWidth / doc.width })
    };

    componentDidMount() {
        window.addEventListener("resize", this.handleResize);
    }

    componentWillUnmount() {
        window.addEventListener("resize", this.handleResize);
    }
    render() {
        const docsColumn = [];
        const docsRow = [];
        for (let i = 0; i < this.state.countColumn; i++)docsColumn.push(i);
        for (let i = 0; i < this.state.countRow; i++)docsRow.push(i);
        return docsRow.map(row => <div>
            {docsColumn.map(col => row%2===0 && col===0?<span style={rectangleTransparent}>{col}</span>:<span style={rectangle}>{col}</span>)}
        </div>);
    }
}
export default Background