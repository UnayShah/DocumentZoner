import Login from "./components/Login";
import './App.css';
import Background from "./components/Background";
import Home from "./components/Home";
import OpenFile from "./components/OpenFile";
import FileDetails from "./components/FileDetails";
// const classes = makeStyles(theme => {

//   backgroundStyle: { top: 0, 
//     left: 0, 
//     display: "absolute", 
//     width: "fit-content" },
// });
function App() {
  // const classes = useState(backgroundStyle);

  return (
    <div className="App">
      {/* <Background /> */}
      {/* <div className="Login"> */}
      <Home/>
      {/* <OpenFile fileId='773b12eb-e50f-44f7-b89c-b42df0e39dde' /> */}
      {/* <OpenFile fileId='ee583ab1-b49b-465b-82fd-b6a816c0dabf' /> */}
      {/* <OpenFile fileId='c7d08806-6bbd-4b24-ae9c-009950861df7' /> */}
      {/* </div> */}
    </div>
  );
}

export default App;
