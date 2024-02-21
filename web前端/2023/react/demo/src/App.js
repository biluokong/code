// 项目的根组件

function handleClick(str) {
  console.log(str);
}
function App() {
  return (
    <div className="App">
      <button onClick={handleClick('name')}>click me</button>      
    </div>
  );
}

export default App;
